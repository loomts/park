/*!
 *  build: vue-admin-better 
 *  vue-admin-beautiful.com 
 *  https://gitee.com/chu1204505056/vue-admin-better 
 *  time: 2022-8-24 22:47:40
 */
(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-20caf7ef"],{"0caa":function(s,e,t){"use strict";t("90aa")},"90aa":function(s,e,t){},"9ed6":function(s,e,t){"use strict";t.r(e);var r=function(){var s=this,e=s._self._c;return e("div",{staticClass:"login-container"},[e("el-row",[e("el-col",{attrs:{xs:24,sm:24,md:12,lg:16,xl:16}},[e("div",{staticStyle:{color:"transparent"}},[s._v("占位符")])]),e("el-col",{attrs:{xs:24,sm:24,md:12,lg:8,xl:8}},[e("el-form",{ref:"form",staticClass:"login-form",attrs:{model:s.form,rules:s.rules,"label-position":"left"}},[e("div",{staticClass:"title"},[s._v("hello !")]),e("div",{staticClass:"title-tips"},[s._v("欢迎来到"+s._s(s.title)+"！")]),e("el-form-item",{staticStyle:{"margin-top":"40px"},attrs:{prop:"username"}},[e("span",{staticClass:"svg-container svg-container-admin"},[e("vab-icon",{attrs:{icon:["fas","user"]}})],1),e("el-input",{directives:[{name:"focus",rawName:"v-focus"}],attrs:{placeholder:"请输入用户名",tabindex:"1",type:"text"},model:{value:s.form.username,callback:function(e){s.$set(s.form,"username","string"===typeof e?e.trim():e)},expression:"form.username"}})],1),e("el-form-item",{attrs:{prop:"password"}},[e("span",{staticClass:"svg-container"},[e("vab-icon",{attrs:{icon:["fas","lock"]}})],1),e("el-input",{key:s.passwordType,ref:"password",attrs:{type:s.passwordType,tabindex:"2",placeholder:"请输入密码"},nativeOn:{keyup:function(e){return!e.type.indexOf("key")&&s._k(e.keyCode,"enter",13,e.key,"Enter")?null:s.handleLogin.apply(null,arguments)}},model:{value:s.form.password,callback:function(e){s.$set(s.form,"password","string"===typeof e?e.trim():e)},expression:"form.password"}}),"password"===s.passwordType?e("span",{staticClass:"show-password",on:{click:s.handlePassword}},[e("vab-icon",{attrs:{icon:["fas","eye-slash"]}})],1):e("span",{staticClass:"show-password",on:{click:s.handlePassword}},[e("vab-icon",{attrs:{icon:["fas","eye"]}})],1)],1),e("el-button",{staticClass:"login-btn",attrs:{loading:s.loading,type:"primary"},on:{click:s.handleLogin}},[s._v(" 登录 ")]),e("router-link",{attrs:{to:"/register"}},[e("div",{staticStyle:{"margin-top":"20px"}},[s._v("注册")])])],1)],1)],1)],1)},a=[],o=(t("d9e2"),t("61f7")),i={name:"Login",directives:{focus:{inserted(s){s.querySelector("input").focus()}}},data(){const s=(s,e,t)=>{""==e?t(new Error("用户名不能为空")):t()},e=(s,e,t)=>{Object(o["isPassword"])(e)?t():t(new Error("密码不能少于6位"))};return{nodeEnv:"production",title:this.$baseTitle,form:{username:"",password:""},rules:{username:[{required:!0,trigger:"blur",validator:s}],password:[{required:!0,trigger:"blur",validator:e}]},loading:!1,passwordType:"password",redirect:void 0}},watch:{$route:{handler(s){this.redirect=s.query&&s.query.redirect||"/"},immediate:!0}},created(){document.body.style.overflow="hidden"},beforeDestroy(){document.body.style.overflow="auto"},mounted(){this.form.username="admin",this.form.password="123456",setTimeout(()=>{this.handleLogin()},3e3)},methods:{handlePassword(){"password"===this.passwordType?this.passwordType="":this.passwordType="password",this.$nextTick(()=>{this.$refs.password.focus()})},handleLogin(){this.$refs.form.validate(s=>{if(!s)return!1;this.loading=!0,this.$store.dispatch("user/login",this.form).then(()=>{const s="/404"===this.redirect||"/401"===this.redirect?"/":this.redirect;this.$router.push(s).catch(()=>{}),this.loading=!1}).catch(()=>{this.loading=!1})})}}},n=i,l=(t("0caa"),t("2877")),d=Object(l["a"])(n,r,a,!1,null,"7131b05b",null);e["default"]=d.exports}}]);