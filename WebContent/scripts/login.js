/* 
 * @Author: wang
 * @Date:   2018-12-26
 * @Last 登录模块
 */
const login = {
    init: function () {
        this.render();
        this.bindEvent();
    },
    render: function () {
        this.submitBtn = document.querySelector("#submit");
    },
    bindEvent: function () {
        this.submitBtn.addEventListener("click", this.methods.log.bind(this), false);
    },
    methods: {
        log: function (e) {
            console.log("123")
            e.preventDefault();
            var drag = this.methods.isTrue();
            drag ? this.methods.loginQuest() :alert("您的账号或密码不能为空！");
        },
        isTrue: function () {
            var username = document.querySelector("#username");
            var password = document.querySelector("#password");
            return username.value == "" || password.value == "" ? false : true;
        },
        /**
         *登录请求，
         */
        loginQuest: function () {
        	var userValue = document.querySelector("#username").value;
        	var passValue = document.querySelector("#password").value;
        	console.log(userValue,passValue);
        	var url=`http://localhost:8080/Blogs/Login?username=${userValue}&password=${passValue}`;
            fetch(url,{
            	method:"GET",
            }).then(res => res.json()).then((data) => {
                if(data){
                	window.location.href="./main.html";
                }else{
                	alert("您的账号或密码输入错误！");
                }
            }).catch(err => {
                alert("登录失败");
            });
        }
    }

}
login.init();