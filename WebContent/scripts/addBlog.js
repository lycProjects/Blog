const param = window.location.href.split("?")[1] || false;
const id = param ? param.split("=")[1]: false;

const title = document.getElementById("title");
const tag = document.getElementById("tag");
const status = document.getElementById("status");
const content = document.getElementById("content");
const btn = document.getElementById("btn");
const addTitle = document.getElementById("add_title");
class Init{
    constructor(id){
    	addTitle.innerHTML = "修改博客";
        this.queryMessage(id);
    }
    queryMessage(id){
        var url = `http://localhost:8080/Blogs/selectBlog?id=${id}`;
        fetch(url,{
            method : "GET",
        }).then(res => res.json()).then(data => {
            title.value = data.title;
            tag.value = data.tag;
            status.value = data.status;
            content.value = data.content;
        })
    }
}
id&& new Init(id);

class Operation{
    constructor(){
        this.bindEvent();
    }
    bindEvent(){
        btn.addEventListener('click',this.queryBtn.bind(this),false);
    }
    queryBtn(){
        var b_title = title.value,
              b_tag = tag.value,
              b_status = status.value,
              b_content = content.value;
        if(id){
            var urlParams =`http://localhost:8080/Blogs/UpdateBlog?id=${id}&title=${b_title}&blogType=${b_tag}&content=${b_content}&status=${b_status}`;
            this.update(urlParams);
        }else{
            var urlParams = `http://localhost:8080/Blogs/AddBlog?title=${b_title}&blogType=${b_tag}&content=${b_content}&status=${b_status}`;
            this.increase(urlParams);
        }
    }
    update(urlParams){
    	console.log(urlParams);
        fetch(urlParams,{
        	method: "GET",
        }).then(res => res.json()).then(data => {
        	if(data){
        		alert("修改成功！");
        		window.location.href="./main.html";
        	}else{
        		alert("修改失败！")
        	}
        	
        })
    }
    increase(urlParams) {
        fetch(urlParams,{
        	method:"GET",
        }).then(res => res.json()).then(data => {
        	if(data){
        		alert("添加成功！");
        		window.location.href="./main.html";
        	}else{
        		alert("添加失败！")
        	}
        })
        
    }
    
}
const operation = new Operation();

