import request, { fetch } from '@/utils/request'

// 问答模块-分页
export function questionsList(params) {
  return request.get('/qa/destinationDoubt/page', params)
}

// 问答模块-发起提问
export function launchQuestion(body) {
  //console.log(body);
  return request.post('/qa/destinationDoubt/create', body)
}

// 问答模块-修改问题
export function updateQuestion(body) {
  return request.post('/qa/destinationDoubt/update', body)
}

// 对回答的内容进行点赞(顶)
export function giveLike(body) {
  return request.post('/qa/destinationDoubt/giveLike', body)
}

// 回答问题
export function answer(body) {
  return request.post('/qa/destinationDoubt/answer', body)
}

//我的问答
export function getMeAnswer(params){
  return request.get('/qa/destinationDoubt/self/answer',params);
} 

//我的提问
export function getMeQuestions(params){
  return request.get('/qa/destinationDoubt/self/question',params);
}
//我关注的问题
export function getMeFllow(params){
  return request.get('/qa/destinationDoubt/self/attention',params);
}
//我收藏的问题
export function getMeCollection(params){
  return request.get('/qa/destinationDoubt/self/collect',params);
}

//我的草稿
export function getMeDraft(params){
  return request.get('/qa/destinationDoubt/self/draft',params);
}
//获取详情
export function getQuestionDetail(id){
  return request.get(`/qa/destinationDoubt/detail/${id}`);
}

export function getGlobalDestinations(){
  return request.get('/qa/destinations/global');
}

//收藏问题
export function setAnswerCollectPost(body){
  return request.post(`/qa/destinationDoubt/collect/${body.destinationId}`,body);
};

//取消收藏问题
export function setAnswerCollectUnCollect(body){  
  return request.post(`/qa/destinationDoubt/uncollect/${body.destinationId}`,body);
};

//关注
export function setAnswerAttentionPost(body){
  return request.post(`/qa/destinationDoubt/focus/${body.destinationId}`,body);
};

//取消关注
export function setAnswerAttentionUnFocus(body){
  return request.post(`/qa/destinationDoubt/unfocus/${body.destinationId}`,body)
}

//获取提问目的地列表
export function getAnswerDestList(params){
  return request.get('/mdd/destinations/list',params);
}

//草稿箱问题回显
export function getDraftDetail(id){
 return request.get(`/qa/destinationDoubt/draft/${id}`); 
}
