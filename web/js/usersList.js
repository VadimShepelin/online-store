 function goToUsersOrdersHistory(userId) {
    window.location.href = '/ordersHistoryAdmin?userId=' + userId;
}

function updateCheckboxValue(userId) {
    const checkbox = document.getElementById('blacklistCheckbox');
    checkbox.value = checkbox.checked ? 'true' : 'false';
    window.location.href = '/usersList?userId=' + userId+"&value="+checkbox.value;
}