
import axios from 'axios'
import { dialogShowAuto } from '@/utils/dialog'


const http = axios.create({
    baseURL: 'http://api.dcr.com',
    timeout: 3600,
    withCredentials: true,
    headers: {'X-Requested-With': 'Content-Type'},
    responseType: 'json', 
    //响应数据的编码规则，默认utf-8
    responseEncoding: 'utf8',
    // headers.post['Content-Type']:'application/json'
})

export default http