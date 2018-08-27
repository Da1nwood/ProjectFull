<!DOCTYPE html>
<html>
<head>
	 <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Crypto</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
    <script
			  src="https://code.jquery.com/jquery-3.3.1.min.js"
			  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
			  crossorigin="anonymous"></script>
			  <script src="path/to/chartjs/dist/Chart.js"></script>
    <script src="main.js"></script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
  
  
</head>
<body>
<div class="container">
	<img src="5.jpg" width="100%" height="200px">
</div>

<ul class="nav justify-content-center 11">
<li class="nav-item">
    <a class="nav-link" href="index.html"><h3>Main</h3></a>
  </li>
  <li class="nav-item">
    <a class="nav-link active" href="Bitcoin.html">Bitcoin</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="Lightcoin.html">Lightcoin</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="Satoshi.html">Satoshi</a>
  </li>
  <li class="nav-item">
    <a class="nav-link " href="Etherium.jsp"><h3>Etherium</h3></a>
  </li>
</ul>

<div class="size" align="center">
<div class="raw size">
<div class="col-sm-3 col-md-6">
<div class="1">
<canvas id="myChart" width="200" height="200"></canvas>
<script>
var ctx = document.getElementById("myChart");
var chart = new Chart(ctx, {
    // The type of chart we want to create
    type: 'line',

    // The data for our dataset
    data: {
        labels: ${TimeAdd},
        datasets: [{
        label: "Etherium",
        fillColor: "rgba(50,120,205,0.5)",
        strokeColor: "rgba(50,120,205,0.8)",
        highlightFill: "rgba(50,120,205,0.75)",
        highlightStroke: "rgba(50,120,205,1)",
        data: ${price}
    
    }]
    },
	options: {
        scales: {
            yAxes: [{
                stacked: true
            }]
        }
    }	
    // Configuration options go here
   });
 
</script>
</div>
</div>





</div>
</div>

</body>
</html>