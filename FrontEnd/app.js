class App {
  constructor() {
    const btnArr = document.querySelectorAll(".btn");
    btnArr.forEach((ele) => {
      ele.addEventListener("click", (e) => {
        e.preventDefault();
        if (!localStorage.getItem("AccessToken")) {
          window.location.replace(`login.html`);
          return;
        }
        window.location.replace(`${ele.href}`);
      });
    });
  }
}
const app = new App();
