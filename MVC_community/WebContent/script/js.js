/**
 * 
 */
	setInterval(function() {
		var t = new Date();
		var d = t.toLocaleTimeString();
		document.getElementById('nowTime').innerHTML = d;
	}, 1000)
	
		var num = 2;
		function changePic() {
			var pic = document.getElementById('kakao2');
			if (num%2 == 0) {
				pic.src = "img/dog1.jpg";	
			} else {
				pic.src = "img/dog2.jpg";
			}
			num++;
		}
		setInterval(changePic,2000);
		
		var left = 350;
		var top1 = 200;
		var x = 0;
		var y = 0;
		var check = 0;
		function move() {
			var hurai = document.getElementById('hurai');
			
			if (left == 350 && top1 == 200) {
				check = 1;
				x = -2;
			}else if (left == 150 && top1 == 200){
				check = 2;
				y = -2;
			}else if (left == 150 && top1 == 30){
				check = 3;
				x = 2;
			}else if (left == 350 && top1 == 30){
				check = 4;
				y = 2;
			}
			if(check == 1){
				left += x;
				hurai.style.left = left+"px";
			}else if(check == 2){
				top1 += y;
				hurai.style.top = top1+"px";
			}else if(check == 3){
				left += x;
				hurai.style.left = left+"px";
			}else if(check == 4){
				top1 += y;
				hurai.style.top = top1+"px";
			}
		}
		
		setInterval(move,1);
		
		function showPopup(){
			var writeView = document.getElementById('writeView');
			
			writeView.style.display = 'block';
		}
		function closePopup() {
var writeView = document.getElementById('writeView');
			
			writeView.style.display = 'none';
		}
