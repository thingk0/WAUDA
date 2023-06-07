let buttons = document.querySelectorAll('.footer-btn');

function changeButtonStyle() {
    let currentUrl = window.location.pathname;
    buttons.forEach((btn, idx) => {

        // 프로필 버튼 매칭 URL 추가
        const profileUrls = ['/members/login', '/members/signup', '/members/profile'];

        if (btn.dataset.url === currentUrl || (btn.dataset.url === '/members/login' && profileUrls.includes(currentUrl))) {
            btn.classList.add('button-blue');
            btn.classList.add('button-border');
        } else {
            btn.classList.remove('button-blue');
            btn.classList.remove('button-border');
        }
    });
    localStorage.setItem('selectedButtonIndex', currentUrl);
}

function setSelectedButtonColor() {
    changeButtonStyle();
}

document.addEventListener('DOMContentLoaded', setSelectedButtonColor);

buttons.forEach((button, index) => {
    button.addEventListener('click', () => {
        let url = button.dataset.url;
        window.location.href = url;
    });
});
