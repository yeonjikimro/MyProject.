document.addEventListener("DOMContentLoaded", () => {
  const deal_select = document.querySelector("select.deal");

  deal_select?.addEventListener("change", (e) => {
    const value = e.target.value;
    document.location.href = `${rootPath}/classic/test?mood=${value}`;
  });
});
