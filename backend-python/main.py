from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
from pydantic import BaseModel
from typing import Dict
from threading import Lock

app = FastAPI(title="ShopLite Cart Service")

# Разрешаем CORS для фронтенда
app.add_middleware(
    CORSMiddleware,
    allow_origins=["http://127.0.0.1:5500", "http://localhost:5500", "http://127.0.0.1:8000", "http://localhost:8000"],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

# Модели
class Product(BaseModel):
    id: int
    name: str
    price: int
    image: str

class CartItem(BaseModel):
    id: int
    name: str
    price: int
    image: str
    quantity: int = 1

# Хранилище
cart: Dict[int, CartItem] = {}
cart_lock = Lock()

# Эндпоинты
@app.post("/api/cart/add")
async def add_to_cart(product: Product):
    with cart_lock:
        if product.id in cart:
            cart[product.id].quantity += 1
        else:
            cart[product.id] = CartItem(**product.dict(), quantity=1)
        return {"message": "Товар добавлен в корзину"}

@app.delete("/api/cart/remove/{product_id}")
async def remove_from_cart(product_id: int):
    with cart_lock:
        if product_id in cart:
            del cart[product_id]
            return {"message": "Товар удалён из корзины"}
        return {"error": "Товар не найден"}

@app.get("/api/cart")
async def get_cart():
    with cart_lock:
        return list(cart.values())

@app.get("/")
async def root():
    return {"service": "ShopLite Cart API", "status": "OK"}

if __name__ == "__main__":
    import uvicorn
    uvicorn.run(app, host="127.0.0.1", port=8001)