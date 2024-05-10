const base = {
    get() {
        return {
            url : "http://localhost:8080/ssm6a212/",
            name: "ssm6a212",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssm6a212/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "科创微应用平台小程序"
        } 
    }
}
export default base
