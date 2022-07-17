const APP_ID = 'appmusicas-yhyrb';
const ATLAS_SERVICE = 'mongodb-atlas';
const app = new Realm.App({id: APP_ID});

// Função executada no botão Login.
const login = async () => {
    const credentials = Realm.Credentials.anonymous();
    try {
        const user = await app.logIn(credentials);
        $('#user').empty().append("User ID: " + user.id); // update the user div with the user ID
    } catch (err) {
        console.error("Failed to log in", err);
    }
};

// Função executada no botão Listar 20 Filmes.
const find_movies = async () => {
    let collMovies;
    try {
        // Acessa a coleção movies através do MDB Realm com a regra readonly.
        const mongodb = app.currentUser.mongoClient(ATLAS_SERVICE);
        collMovies = mongodb.db("musimundos").collection("musimundos");
    } catch (err) {
        $("#user").append("Need to login first.");
        console.error("Need to log in first", err);
        return;
    }

    // Recupera 20 títulos de filmes (apenas os títulos conforme a projeção).
    const musimundos_musica = await collMovies.find({}, {
        "projection": {
            "_id": 0,
            "musica": 1
        },
        "limit": 20
    });

    // Acessa a div movies e limpa o conteúdo.
    let movies_div = $("#movies");
    movies_div.empty();

    // Percorre o título de 20 filmes e exibe os nomes na div movies.
    for (const musica of musimundos_musica) {
        let p = document.createElement("p");
        p.append(musica.musica);
        movies_div.append(p);
    }
};