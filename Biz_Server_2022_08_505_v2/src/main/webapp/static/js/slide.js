document.addEventListener("DOMContentLoaded", () => {
  const IMAGE_WIDTH = 300;
  const preBtn = document.querySelector("button.btn_prev");
  const nextBtn = document.querySelector("button.btn_next");
  const images = document.querySelector("div.images");
  // 화면 slide 되는 이미지 개수를 담는 변수
  const imgCount = document.querySelectorAll("div.images img").length;

  let position = 0;
  let curPosition = 0;
  if (preBtn) {
    preBtn.addEventListener("click", () => {
      if (curPosition > 0) {
        position += IMAGE_WIDTH;
        images.style.transform = `translateX(${position}px)`;
        curPosition--;
      }
    });
  }
  if (nextBtn) {
    nextBtn.addEventListener("click", () => {
      if (curPosition < imgCount - 1) {
        position -= IMAGE_WIDTH;
        images.style.transform = `translateX(${pos}px)`;
        curPosition++;
      }
    });
  } // end if nextBtn

  const badge_click_cb = (e, pos) => {
    console.log("badge index : ", pos);
    // 만약 3번 badge를 클릭했다 라고 하면
    // -2 * IMAGE_WIDTH 가 계산되고
    // -1200
    // 현재 위치가 3번인데 0을 클릭했다
    // transX 는 0 이 된다.
    const transX = -pos * IMAGE_WIDTH;
    images.style.transform = `translateX(${transX}px)`;
  };
  // span.badge 를 감싸고 있을 부모 tag(container)
  const divBadge = document.querySelector("div.badge");
  for (let index = 0; index < imgCount; index++) {
    // tag를 JS 코드에서 동적으로 생성하기
    const span = document.createElement("span");
    // 생성된 span tag에 badge 클래스를 추가하고
    span.classList.add("badge");
    span.addEventListener("click", (e) => {
      badge_click_cb(e, index);
    });

    // 생성된 span tag 를 div.badge tag 에 child 로 추가하라
    divBadge.appendChild(span);
  }

  let count = 0;
  const interval_cb = (e) => {
    badge_click_cb(e, ++count % imgCount);
    if (count > imgCount * 100) count = 0;
  };

  // 2초마다 슬라이딩이 되도록 설정
  let interval = setInterval(interval_cb, 2000);

  //div.image_window 에 마우스가 over되면 interval 취소
  // div.image_window 에서 마우스가 out 되면 다시 시작
  const image_window = document.querySelector("div.image_window");
  if (image_window) {
    // 마우스가 이미지에 올라가면 interval 취소
    image_window.addEventListener("mouseover", () => {
      clearInterval(interval);
    });
    image_window.addEventListener("mouseout", () => {
      interval = setInterval(interval_cb, 2000);
    });
  }
}); // end document.addEvent("DOMContentLoaded")
