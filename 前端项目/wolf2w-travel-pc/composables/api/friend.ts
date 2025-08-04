import request, { fetch } from '@/utils/request';
import qs from 'querystring'


export function getFollow(){
    return request.get('/system/users/IFollower');
}

export function getFans(){
    return request.get('/system/users/myFollower');
}

export function followOperate(params){
    return request.post(`/system/users/followOperate?userId=${params}`);
}