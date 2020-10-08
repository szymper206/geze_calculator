/*
document.addEventListener("DOMContentLoaded", function() {

    var firstArticle = document.getElementById("productType");

    firstArticle.style.visibility = "hidden";
});

    function onChangeOptionFunction(selectElement) {
        for(var i = 0; i < selectElement.children.length; i++) {
            var element = selectElement.children[i];
            if(element.selected) {
                if(element.innerText === "Windows") {
                    document.querySelector("img:nth-child(4)").style.visibility = "visible";
                }
                if(element.innerText === "Os X") {
                    document.querySelector("img:nth-child(2)").style.visibility = "visible";
                }
                if(element.innerText === "Ubuntu") {
                    document.querySelector("img:nth-child(3)").style.visibility = "visible";
                }
            }
        }
    }

    var foundedSelectElement = document.querySelector("select");
    hideProductType();
    onChangeOptionFunction(foundedSelectElement);

    foundedSelectElement.addEventListener("change", function () {
        hideProductType();
        onChangeOptionFunction(this);
    });
});
*/
