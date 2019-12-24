<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="x"  uri="http://java.sun.com/jsp/jstl/xml" %> 
<%@ taglib prefix="sql"  uri="http://java.sun.com/jsp/jstl/sql" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.css">
</head>
<body>

<h3>막대Chart그리기</h3>
<hr/>
<!-- 서버로 부터 받은 데이터를 이용해 가공한 그래프가 들어갈 위치 지정(실제 그래프는 canvas엘리먼트안에 넣어줌 -->
<div class="container" style="border:1px solid black;">
	<canvas id="canvas" style="height:350px;width:600px;"></canvas>
</div>

<br/><br/>
<a href="bar">Bar그래프</a><br>
<a href="pie">Pie그래프</a><br>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.js"></script>

<script>
$(document).ready(function(){
	var chartLabels = []; //월표시
	var chartData1 = []; //pc판매량
	var chartData2 = []; //모니터 판매량
	
	var lineChartData = { //그래프를 그릴수 있도록 가공해둔 변수
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
			        data : chartData2	
				}
			]
	};
	
	function createChart()  {
		var ctx = document.getElementById("canvas").getContext("2d");
		LineChartDemo = Chart.Line(ctx,{ //Chart.Line()메서드는 Chartjs에서 제공한 막대그래프그리기 메서드
			data : lineChartData,
			options : {
				scales : {
					yAxes : [
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
		url : 'json',
		data : {
            cmd : 'chart',
            subcmd : 'line'
        },
        dataType : 'json',
        success : function(result){
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