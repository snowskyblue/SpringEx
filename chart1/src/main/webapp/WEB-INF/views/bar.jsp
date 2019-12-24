<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!--font-awesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.css">

<title>Insert title here</title>
</head>
<body>

<h3>Bar chart 막대그래프 그리기</h3>
<hr/>

<div class="container" style="border:1px solid black;">
	<div>
		<canvas id="canvas" style="height:350px; width:600px;"></canvas>
	</div>
</div>
<br/><br/>

<!--jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!--popper -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!--javascript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!-- chart.js -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.js"></script>

<script>
$(document).ready(function(){
	var chartLabels = []; //월표시(배열)
	var chartData1 = []; //pc판매량(배열)
	var chartData2 = []; //모니터 판매량(배열)
	
	var lineChartData = { //chartLabels,chartData1, chartData2 넣어서 차트만들때 사용할 변수
			labels : chartLabels, //x축 표시
			datasets : [
				{
					label : "월별 PC 판매량",
					fillColor : "rgba(220,220,220,0.2)",
			        strokeColor : "rgba(220,220,220,1)",
			        pointColor : "rgba(220,220,220,1)",
			        pointStrokeColor : "#fff",
			        pointHighlightFill : "#fff",
			        pointHighlightStroke : "rgba(220,220,220,1)",
			        backgroundColor : [
			        	"#FF6384",
			        	"#4BC0C0",
			        	"#FFCE56",
			        	"#E7E9ED",
			        	"#36A2EB"
			        ],
			        data : chartData1		
				},
				{
					label : "월별 모니터 판매량",
			        fillColor : "rgba(151,187,205,0.2)",
			        strokeColor : "rgba(151,187,205,1)",
			        pointColor : "rgba(151,187,205,1)",
			        pointStrokeColor : "#fff",
			        pointHighlightFill : "#fff",
			        pointHighlightStroke : "rgba(151,187,205,1)",
			        backgroundColor : [
			        	"#FF6384",
			        	"#4BC0C0",
			        	"#FFCE56",
			        	"#E7E9ED",
			        	"#36A2EB"
			        ],
			        data : chartData2	
				}
			]
	}
	
	function createChart() {
		var ctx = document.getElementById("canvas").getContext("2d");
		new Chart(ctx,{
			type : 'horizontalBar', //수평 막대 그래프
			data : lineChartData,
			options : {
				scales : {
					xAxes : [
						{
							ticks : {
								beginAtZero : true
							}
						}
					]
				}
			}
		});	
	}
	
	$.ajax({
		type : 'POST',
		url : 'json', //HomeController에서  RequestMapping("json")
		data : {
            cmd : 'chart',
            subcmd : 'line' //HomeController에서 request.getParameter("subcmd")=line;
        },
        dataType : 'json',
        success : function(result){ //out.print(jobj_data); JSONObject jobj_data
        	$.each(result.datas,function(index, obj){ //자바의 enhanced for문을 생각 할것
        		chartLabels.push(obj.month); //배열에 값을 넣어줌
                chartData1.push(obj.pc);
                chartData2.push(obj.monitor);
        	});
        	
        	createChart();
        },
        error : function() {
        	alert('There is an error : method(group)에 에러가 있습니다.');
        }
	});
});
</script>

</body>
</html>