<script setup lang="ts">
import request, { fetch } from '@/utils/request'
import md5 from 'js-md5'

function addSign(params) {
  let sdic=Object.keys(params).sort()
  let signStr = ""
  sdic.forEach(item=>{
    if(signStr == ""){
      signStr += item + "=" + params[item]
    }else{
      signStr +="&"+item+"="+ params[item]
    }
  })

  params.sign = md5(signStr).toUpperCase()
  return params
}
onMounted(() => {
  nextTick(() => {
    let timestamp = new Date().getTime();
    let a = {a:1, c:3,d:4, b:2};
    a.timestamp = timestamp;
    let params = addSign(a);
    request.get('/adv/test2', params).then(resp=>{
      console.log(resp)
    })
  })
})
</script>
