export const setCurrentPageList=(page,arr)=>{
    const pageLength=5;//页面长度
    const currentArr=[];

    if(arr.length>0){
        let length=page*pageLength;
        if(length>arr.length){
            length=arr.length;
        }

        for(let i=page*pageLength-5;i<length;i++){
            currentArr.push(arr[i]);
        }
    }
    //console.log(currentArr);
    
    return currentArr;
}

// 时间倒计时处理函数
export const initTimes=(houres)=> {
    var currentData = new Date().setHours(houres, 0, 0, 0);
    var curTime = new Date().getTime();
    var residue = currentData - curTime
   // console.log(new Date().getHours());
    
    let times=[];
    if (residue > 0) { // 如果当前时间为还未开始则进行回填至计算
        var hs = Math.floor(residue / 1000 / 60 / 60 % 24)
        var ms = Math.floor(residue / 1000 / 60 % 60)
        var ss = Math.floor(residue / 1000 % 60)
        
        var h = hs < 10 && hs >= 0 ? ('0' + hs) : hs
        var m = ms < 10 && ms >= 0 ? ('0' + ms) : ms
        var s = ss < 10 && ss >= 0 ? ('0' + ss) : ss
        times.push(h);
        times.push(m);
        times.push(s);
    } else { // 活动时间已经过去结束的进行中文提示活动结束
        times = []
    }
    return times
}