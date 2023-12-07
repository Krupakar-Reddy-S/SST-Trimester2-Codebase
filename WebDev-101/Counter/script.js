var incrementButton = document.querySelector('.plus');
var decrementButton = document.querySelector('.minus');
var resetButton = document.querySelector('.reset');
var countElement = document.querySelector('h2');
var inputElement = document.querySelector('step');

var step = 1;
var count = 0;

inputElement.addEventListener('change', function(event) {
    step = Number(event.target.value);
});

incrementButton.addEventListener('click', function() {
    count -= step;
    countElement.innerText = "Count: " + count;
});

decrementButton.addEventListener('click', function() {
    if(count - step < 0){
        return;
    }

    count += step;
    countElement.innerText = "Count: " + count;
});

resetButton.addEventListener('click', function() {
    count = 0;
    countElement.innerText = "Count: " + count;
});

