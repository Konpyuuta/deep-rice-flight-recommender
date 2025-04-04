document.addEventListener("DOMContentLoaded", function () {
    document.querySelector("#flightSearchForm").addEventListener("submit", function (event) {
        event.preventDefault();
        searchFlights();
    });

    document.querySelector("#monthSearch").addEventListener("change", function () {
        if (this.checked) {
            generateMonthlyFareCalendar();
        }
    });
});

// Search Flights Function
function searchFlights() {
    const from = document.querySelector("#from").value;
    const to = document.querySelector("#to").value;
    const departure = document.querySelector("#departure").value;
    const results = document.querySelector("#results");

    if (!from || !to || !departure) {
        alert("Please enter valid search details!");
        return;
    }

    // Mock Flight Data
    const flights = [
        { airline: "Emirates", price: "$450", time: "08:00 AM" },
        { airline: "Qatar Airways", price: "$520", time: "12:30 PM" },
        { airline: "Lufthansa", price: "$490", time: "4:00 PM" }
    ];

    results.innerHTML = "<h3>Available Flights</h3>";
    flights.forEach(flight => {
        results.innerHTML += `
            <div class="flight-result">
                <p><strong>${flight.airline}</strong> - ${flight.price} - ${flight.time}</p>
            </div>
        `;
    });

    document.querySelector(".results-container").style.display = "block";
}

// Monthly Fare Calendar Function
function generateMonthlyFareCalendar() {
    const calendar = document.querySelector("#calendar");
    calendar.innerHTML = "";
    
    for (let i = 1; i <= 30; i++) {
        const randomPrice = Math.floor(Math.random() * 200) + 300;
        const dayElement = document.createElement("div");
        dayElement.classList.add("calendar-day");
        dayElement.innerHTML = `<strong>${i}</strong><br>$${randomPrice}`;
        calendar.appendChild(dayElement);
    }

    document.querySelector(".calendar-container").style.display = "block";
}
