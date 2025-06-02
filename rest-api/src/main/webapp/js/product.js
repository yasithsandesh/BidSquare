const productForm = document.getElementById("productForm");
if(productForm){
    productForm.addEventListener("submit",async (evt)=>{
        evt.preventDefault();

        const productDTO = {
            name:productForm.name.value,
            description:productForm.description.value,
            startingPrice:productForm.price.value,
            currentHighestBid:productForm.price.value,
            url:productForm.url.value
        }

        await fetch("http://localhost:8080/ProductCon",{
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(productDTO),
        }).then(response=>response.json()).then((responseDTO)=>{
            if(responseDTO.status){
                window.location = "home.jsp"
            }else{
                alert(responseDTO.message);
                console.log(responseDTO.status)
            }
        }).catch((err)=>{
            console.log(err)
        })

    })
}

document.addEventListener("DOMContentLoaded",async ()=>{
    await fetch("http://localhost:8080/ProductCon")
        .then(response=>response.json()).then((products)=>{
            generateUI(products)
    }).catch((err)=>{
        console.log(err)
    })
})



const generateUI = (products)=>{

    const productContainer = document.getElementById("product-list");
    productContainer.innerHTML = ""

    if(products.length === 0){
        productContainer.innerHTML = "<p>No products available.</p>";
    }else{
        products.forEach(product=>{

            const card = document.createElement("div");
            card.className = "product-card";

            card.innerHTML = `
                  <img src="../css/bid.png" alt="${product.name}" class="product-img"/>
                  <h3>${product.name}</h3>
                  <p>${product.description}</p>
                  <p><strong>Starting Price:</strong> $${product.startingPrice}</p>
                  <p><strong>Current Highest Bid:</strong> $${product.currentHighestBid}</p>
                  <p><strong>Status:</strong> ${product.isSold ? "Sold" : "Available"}</p>
                   <input type="number" placeholder="Enter bid price" class="bid-input" id="bid-${product.id}"/>
                   <button class="bid-button" data-id="${product.id}">Bid Now</button>
            `;

            productContainer.appendChild(card);

        })
    }
}

//listener btn
document.addEventListener("click",async (e)=>{
    if(e.target && e.target.classList.contains("bid-button")){
        const productId = e.target.getAttribute("data-id");
        const bidInput = document.getElementById(`bid-${productId}`);
        const bidPrice = bidInput.value;
        const userId = document.getElementById("userInput").textContent;

        const bidDTO = {
            userId:userId,
            productId:productId,
            bidAmount:bidPrice
        }

        await fetch("http://localhost:8080/Bid",{
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(bidDTO),
        })
            .then(response=>response.json()).then((products)=>{
                generateUI(products)
            }).catch((err)=>{
                console.log(err)
            })
    }
})