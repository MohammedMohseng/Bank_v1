'use strict';

const root = document.getElementById(`root`);

root.innerHTML = get("tasks");

const get = async (route) => {
    const res = await fetch(`http://localhost:/${route}`, {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        }
    });

    const data = (await res).json();
    return data;
}

const post = async (route, dataToPost) => {
    const res = await fetch(`http://localhost:/${route}`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(dataToPost)
    });

    const data = (await res).json();
    return data;
}

