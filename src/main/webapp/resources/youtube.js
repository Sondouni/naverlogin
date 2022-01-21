let searchYouTubeFrmElem = document.querySelector('#searchYouTubeFrm');
let myApiKey = "AIzaSyBZRrYQ1XdveD-B4yT0gqbmNdp1HkZr5nY";
console.log(searchYouTubeFrmElem);
searchYouTubeFrmElem.addEventListener('submit',function (e){
    e.preventDefault();
    if(searchYouTubeFrmElem.searchText){
        let searchVal = searchYouTubeFrmElem.searchText.value;

        let url = `https://www.googleapis.com/youtube/v3/search?q=${searchVal}&key=${myApiKey}`;
        console.log(url);
        fetch(url)
            .then((res)=>{
                return  res.json();
            }).then((data)=>{
                console.log(data);
            data.items.forEach((item)=>{
                if(item.id.videoId){
                    let vidDivElem = document.createElement('div');
                    vidDivElem.innerHTML = `
                        <iframe class="iframeVid"
                            src="https://www.youtube.com/embed/${item.id.videoId}"
                            width="300" height="180"
                            allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                            allowfullscreen>
                        </iframe>
                    `;
                    document.querySelector('body').append(vidDivElem);
                }
            });
        });
    }else {
        alert('글을 작성해주세요')
    }
});