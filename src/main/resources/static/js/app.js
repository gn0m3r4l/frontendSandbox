async function fetchStates() {
    try {
        const res = await fetch("/api/states");
        const data = await res.json();

        const container = document.getElementById("stateList");
        container.innerHTML = "";

        data.forEach(item => {
            const card = document.createElement("div");
            card.className = "state-card";

            const colorBox = document.createElement("div");
            colorBox.className = "state-color-box";
            colorBox.style.backgroundColor = `rgb(${item.red},${item.green},${item.blue})`;

            const text = document.createElement("div");
            text.className = "state-text";
            text.textContent = item.name;

            card.appendChild(colorBox);
            card.appendChild(text);

            container.appendChild(card);
        });

    } catch (e) {
        console.error("Fehler beim Laden der States:", e);
    }
}

async function fetchLogs() {
    try {
        const res = await fetch("/api/logs");
        const lines = await res.json();

        const logView = document.getElementById("logView");

        logView.textContent = lines.join("\n");
        logView.scrollTop = logView.scrollHeight;

    } catch (e) {
        console.error("Fehler beim Laden der Logs:", e);
    }
}

function poll() {
    fetchStates();
    fetchLogs();
}

poll();
setInterval(poll, 2000);
