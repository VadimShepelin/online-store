 function updatePrice(input) {
    const pricePerUnit = parseInt(input.closest('.cart-item').getAttribute('data-price'));
    const quantity = parseInt(input.value);
    const newPrice = pricePerUnit * quantity;

    input.closest('.cart-item').querySelector('.price').textContent = newPrice + ' ₽ ';
    updateTotalPrice();
}

    function updateTotalPrice() {
    let total = 0;
    document.querySelectorAll('.cart-item').forEach(item => {
    const priceText = item.querySelector('.price').textContent;
    const price = parseFloat(priceText);
    total += price;
});
    document.getElementById('totalPrice').textContent = total + ' ₽ ';
}

    function updateInputPrice() {

    const totalPrice = document.getElementById('totalPrice').innerText;
    document.getElementById('totalPriceInput').value = totalPrice;
    console.log('Total Price:', totalPrice);

    return true;
}

    window.onload = updateTotalPrice;