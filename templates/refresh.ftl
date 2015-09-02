<html>
<head>
    <title>Refresh every second</title>
</head>
<body onload="myOnloadFunc()">
    Hi, dear
</body>
<script>
    function myOnloadFunc() {
            setInterval(function(){
                refresh()
            }, 1000);
    }
    function refresh() {
        location.reload(true);
    }
</script>
</html>