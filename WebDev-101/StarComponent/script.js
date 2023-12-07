var allStar = document.querySelectorAll(".star")
var h4Element = document.querySelector("h4");

for(var i=0;i<allStar.length;i++){
    allStar[i].addEventListener('click',function(e){
        // console.log(e.target.classList);
        var starClicked = e.target.classList[1];
        console.log(starClicked);
        // for(var j=0;j<allStar.length;j++){
        //     allStar[j].classList.remove("yellow");
        // }
        removeColor(allStar.length);

        // for(var j=0;j<starClicked;j++){
        //     allStar[j].classList.add("yellow");
        // }
        addColor(starClicked);

        prevClicked = starClicked;
        h4Element.innerText = "Rating : " + starClicked;
    })

    allStar[i].addEventListener('mouseover',function(e){
        var starClicked = e.target.classList[1];

        // for(var j=0;j<prevClicked;j++){
        //     allStar[j].classList.remove("yellow");
        // }
        removeColor(prevClicked);

        // for(var j=0;j<starClicked;j++){
        //     allStar[j].classList.add("yellow");
        // }
        addColor(starClicked);
    })
    
    allStar[i].addEventListener('mouseleave',function(e){

        // for(var j=0;j<allStar.length;j++){
        //     allStar[j].classList.remove("yellow");
        // }
        removeColor(allStar.length);

        // for(var j=0;j<prevClicked;j++){
        //     allStar[j].classList.add("yellow");
        // }ss
        addColor(prevClicked);
    })
}


function addColor(num){
    for(var j=0;j<num;j++){
        allStar[j].classList.add("yellow");
    }
}

function removeColor(num){
    for(var j=num;j<allStar.length;j++){
        allStar[j].classList.remove("yellow");
    }
}