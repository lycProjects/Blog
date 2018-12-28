/* 
* @Author: wang
* @Date:   2018-12-26
* @Last 注册模块
*/
const registe = {
    init: function(){
        this.render();
        this.bindEvent();
    },
    render: function(){
        this.submitBtn = document.querySelector("#submit");
    },
    bindEvent: function(){

        this.submitBtn.addEventListener("click", this.methods.regis.bind(this), false);
    },
    methods : {
        regis : function(e){
            e.preventDefault();
            var drag = this.methods.isTrue();
            drag&&this.methods.registeQuest();
        },
        isTrue:function(){
            var username = document.querySelector("#username");
            var password = document.querySelector("#password");
            var pass = document.querySelector("#pass");
            var nickname = document.querySelector("#nickname");
            var email = document.querySelector("#email");
            return username.value != "" && password.value != "" && nickname.value != "" && email.value != "" && password.value == pass.value ? true : false;
        },
        /**
         *注册请求，
         */
        registeQuest : function(){
        	var username = document.querySelector("#username").value;
        	var password = document.querySelector("#password").value;
        	var nickname = document.querySelector("#nickname").value;
        	var email = document.querySelector("#email").value;
            var url=`http://localhost:8080/Blogs/Register?username=${username}&password=${password}&nickname=${nickname}&email=${email}`;
            fetch(url,{
            	method: "GET",
            }).then(res => res.json()).then((data) => {
            	console.log(data);
            	if(data){
            		alert("注册成功！");
            		window.location.href="login.html";
            	}else{
            		alert("用户已存在！");
            	}
                
            }).catch(err=> {
                alert("注册失败");
            });
        }
    }

}
registe.init();
