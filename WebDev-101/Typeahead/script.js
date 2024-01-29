let baseUrl = fetch("https://www.swiggy.com/dapi/restaurants/search/suggest?lat=12.9715987&lng=77.5945627&str=")

async function getSuggestions(query) {
    let div = document.getElementById("suggestions");

    let response = await fetch("https://www.swiggy.com/dapi/restaurants/search/suggest?lat=12.9715987&lng=77.5945627&str=" + query);
    let json = await response.json();
    
    if (json.statusMessage === "Invalid query string")  {
        div.innerHTML = "";
        return;
    }

    let suggestions = json.data.suggestions;
    console.log(suggestions);

    let ul = document.createElement("ul");
    for (let i = 0; i < suggestions.length; i++) {
        let li = document.createElement("li");
        li.innerText = suggestions[i].text;
        ul.appendChild(li);
    }

    div.innerHTML = "";
    div.appendChild(ul);
}

let input = document.querySelector("input");

input.addEventListener("keydown", function () {
    getSuggestions(input.value);
})
