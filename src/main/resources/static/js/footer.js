let buttons = document.querySelectorAll('.footer-btn');

function changeButtonStyle() {
    let currentUrl = window.location.pathname;

    // '/party/{id}'와 매칭하는 정규표현식
    const partyPattern = new RegExp('^/party/\\d+$');
    // '/members/**'와 매칭하는 정규표현식
    const memberPattern = new RegExp('^/members/.*$');

    buttons.forEach((btn, idx) => {
        if (btn.dataset.url === currentUrl ||
            (memberPattern.test(currentUrl) && idx == 4) ||
            (partyPattern.test(currentUrl) && idx === 0)) {
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


document.querySelector('.custom-input-form input').addEventListener('focus', function() {
    const imgElem = document.querySelector('.custom-input-form button img');
    imgElem.style.opacity = "1";
    imgElem.style.filter = "invert(20%) sepia(100%) saturate(10000%) hue-rotate(210deg)";
});


document.querySelector('.custom-input-form input').addEventListener('blur', function() {
    const imgElem = document.querySelector('.custom-input-form button img');
    imgElem.style.opacity = "0.3";
    imgElem.style.filter = "";  // 필요한 기본 필터 스타일로 변경하세요
});

