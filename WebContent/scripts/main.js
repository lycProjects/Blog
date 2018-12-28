//显示时间
class NowTime{
    constructor(time){
        this.time = time;
        this.showTime();
    }
    showTime(){
        setInterval(() => {
            this.time.innerHTML = this.getTime();
        }, 1000);
    }
    getTime(){
        var date = new Date();
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        var d = date.getDate();
        var h = date.getHours();
        var ms = date.getMinutes();
        var s  = date.getSeconds();
        return `${y}年${m}月${d}日   ${h}:${ms}:${s}`;
    }
}
const timeBox = document.querySelector("#time");
const nowTime = new NowTime(timeBox);

//显示Blog列表
class Nav{
    constructor(lists){
        this.lists = lists;
        this.body = document.querySelector("#tbody");
        this.bindEvent();
        this.queryAll("1");
    }
    bindEvent(){

        this.lists.addEventListener('click',this.navSwitch.bind(this),false);
    }
    navSwitch(e){
        var e = e || window.event;
        var target = e.target || e.srcElement;
        if(target.nodeName == 'LI'){
            this.queryAll(target.value);
        }
    }
    tag(num){
    	var str;
    	switch(num){
	    	case 1:
	    		str =  "热门";
	    		break;
	    	case 2:
	    		str =  "娱乐";
	    		break;
	    	case 3:
	    		str =  "科技";
	    		break;
	    	case 4:
	    		str = "历史";
	    		break;
	    	case 5:
	    		str =  "军事";
	    		break;
	    	case 6:
	    		str =  "电影";
	    		break;
	    	case 7:
	    		str =  "体育";
	    		break;
    	}
    	return str;
    }
    status(num){
    	var str;
    	switch(num){
	    	case 1:
	    		str =  "待发布";
	    		break;
	    	case 2:
	    		str =  "待审核";
	    		break;
	    	case 3:
	    		str =  "已发布";
	    		break;
    	}
    	return str;
    }
    queryAll(tag){
        var _self=this;
        this.body.innerHTML ="" ;
        var url = `http://localhost:8080/Blogs/GetBlogList?id=${tag}`;
        fetch(url,{
            method:"GET",
        }).then(res => res.json()).then(data => {
        	console.log(data);
            data.forEach((item,index)=>{
                var createTr = document.createElement("tr");
                var createTd1 = document.createElement("td");
                createTd1.innerHTML = item.id;
                createTr.appendChild(createTd1)
                var createTd2 = document.createElement("td");
                createTd2.innerHTML = item.title;
                createTr.appendChild(createTd2)
                var createTd3 = document.createElement("td"); 
                createTd3.innerHTML = _self.tag(item.tag);
                createTr.appendChild(createTd3)
                var createTd4 = document.createElement("td");
                createTd4.innerHTML = item.content;
                createTr.appendChild(createTd4)
                var createTd5 = document.createElement("td");
                createTd5.innerHTML = item.lastTime.split(" ")[0];
                
                createTr.appendChild(createTd5)
                var createTd6 = document.createElement("td");
                createTd6.innerHTML = _self.status(item.status);
                createTr.appendChild(createTd6)
                var createTd7 = document.createElement("td");
                createTd7.innerHTML = item.readNum;
                createTr.appendChild(createTd7)
                var createTd8 = document.createElement("td");
                createTd8.innerHTML = item.good;
                createTr.appendChild(createTd8)
                var  btn1 = document.createElement("button");
                var btn2 = document.createElement("button");
                btn1.setAttribute("class","btn btn-primary");
                btn1.innerHTML = "修改";
                btn2.setAttribute("class","btn btn-danger");
                btn2.innerHTML = "删除";
                var createTd9 = document.createElement("td");
                createTd9.appendChild(btn1);
                var createTd10 = document.createElement("td");
                createTd10.appendChild(btn2);
                createTr.appendChild(createTd1);
                createTr.appendChild(createTd2);
                createTr.appendChild(createTd3);
                createTr.appendChild(createTd4);
                createTr.appendChild(createTd5);
                createTr.appendChild(createTd6);
                createTr.appendChild(createTd7);
                createTr.appendChild(createTd8);
                createTr.appendChild(createTd9);
                createTr.appendChild(createTd10);
                _self.body.appendChild(createTr);
            })
        })
    }
}
const ulList = document.querySelector("#ul-list");
const nav = new Nav(ulList);

//增加Blog功能
class AddBlog{
    constructor(btn){
        this.btn = btn;
        this.bindEvent();
    }
    bindEvent(){
        this.btn.addEventListener("click",this.method);
    }
    method(){
        window.location.href = "./addBlog.html";
    }
}
const addBtn = document.querySelector("#add-btn");
const addBolg = new  AddBlog(addBtn);


//删除Blog功能 、修改Blog功能
class DeleteAndUpdate{
    constructor(tbody){
        this.tbody = tbody;
        this.bindEvent();
    }
    bindEvent(){
        this.tbody.addEventListener("click",this.active.bind(this),false);
    }
    active(e){
        var e = e || window.event;
        var target = e.target || e.srcElement;
        if(target.innerHTML == "修改"){
            var tag = target.parentElement.parentElement.firstElementChild.innerHTML;
            window.location.href=`./addBlog.html?id=${tag}`;
        }
        if(target.innerHTML == "删除"){
            var tag = target.parentElement.parentElement.firstElementChild.innerHTML;
             this.delete(tag,target);
        }
    }
     delete(tag,target){
    	var targetParent = target.parentElement.parentElement;
        var url = `http://localhost:8080/Blogs/DeleteBlog?id=${tag}`;
        var _self = this;
        fetch(url,{
            method: "GET",
        }).then(res => res.json()).then(data => {
            if(data){
            	targetParent.remove();
            }else{
            	alert("删除失败");
            }
        });
    } 
}
const tBody = document.querySelector("#tbody");
const deleteAndUpdate = new DeleteAndUpdate(tBody);