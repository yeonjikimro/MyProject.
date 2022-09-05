function getCheckboxValue() {

    // 선택된 목록 가져오기
    const query = 'input[name="m_list"]:checked';
    const selectedEls = document.querySelector(query);

    let result = '';
    selectedEls.forEach((el) => {
        result += el.value + ' ';
    });


    document.getElementById('result').innerText = result;
    
}