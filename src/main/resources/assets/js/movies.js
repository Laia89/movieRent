
const apiRootUrl = '/dw/api';
const apiMoviesUrl = apiRootUrl + '/movies';


setupMovieForm();
loadAndDisplayMovies();


/** Loads movies from API and displays them */
function loadAndDisplayMovies() {

    loadMovies().then(movies => {
        displayMovies(movies);
    });
}


/** Setup of form to add a movie */
function setupMovieForm() {

    $('form').submit(event => {

        console.log("Form submitted");
    event.preventDefault(); // prevents default form behaviour (reloads the page)

    const movie = {
        title: $('#title').val(),
    };

    axios
        .post(apiMoviesUrl, movie)
        .then(response => response.data) // turns to a promise of movie
        .then(addedMovie => {
                console.log("Added movie", addedMovie);
            loadAndDisplayMovies(); // to refresh list
        })
        .catch(error => console.error("Error adding movie!", error));
        });
}


/** Gets movies from API and returns a promise of movies */
function loadMovies() {

    // We return the promise that axios gives us
    return axios.get(apiMoviesUrl)
        .then(response => response.data) // turns to a promise of movies
        .catch(error => {
                console.log("AJAX request finished with an error :(");
            console.error(error);
        });
}

/** Displays movies on the HTML */
function displayMovies(movies) {

    let html = "<ul>";

    for (const movie of movies) {
        html += "<li>" + movie.title + "</li>";
    }

    html += "</ul>";

    const resultDiv = document.getElementById("result");
    resultDiv.innerHTML = html;
}
