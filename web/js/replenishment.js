 function toggleRadio(radio) {
    const selectedRadio = document.querySelector('input[name="amount"]:checked');

    if (selectedRadio) {
    selectedRadio.checked = false;
}
    radio.checked = true;
}