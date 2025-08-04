import { ElMessage, ElMessageBox } from "element-plus";

function createSocket(token){
    var socket;
    if(typeof(WebSocket) == "undefined") {
        console.log("您的浏览器不支持WebSocket");
    }else{
        //var host = window.location.origin.replace("http:","ws:")
        //实现化WebSocket对象，指定要连接的服务器地址与端口  建立连接
        //ws://localhost:9000/ws/token
        socket = new WebSocket("ws://127.0.0.1:9000/ws/"+token);
        //打开事件
        socket.onopen = function() {
            console.log("Socket 已打开");
            //socket.send("这是来自客户端的消息" + location.href + new Date());
        };
        //获得消息事件
        socket.onmessage = function(result) {
            console.log(result.data);
            if(result.data){
                var data =JSON.parse(result.data) ;
                console.log(data);
                
                if(data.orderNo){ 
                    socket.close();                   
                    ElMessageBox.confirm("恭喜你，秒杀成功！查看订单？").then(()=>{
                        navigateTo({path:'/mall/order/detail',query:{'out_trade_no':data.orderNo}}) 
                    }).catch((err)=>{
                        console.log(err);
                    })
                }else{
                    ElMessage.warning('秒杀失败');
                }
            }else{
                ElMessage.warning('秒杀失败');
            }
            
        };
        //关闭事件
        socket.onclose = function() {
            console.log("Socket已关闭");
        };
        //发生了错误事件
        socket.onerror = function() {
            console.log("Socket发生了错误");
        }
    //     //窗口关闭
    //    window.onunload=function(event){
    //         socket.close();
    //     };
    }
    return socket;
}


export default createSocket;