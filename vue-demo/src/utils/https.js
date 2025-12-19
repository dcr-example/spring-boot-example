import axios from '@/axios'
import { useStore } from 'vuex'
import { dialogShowAuto } from '@/utils/dialog'
import { useRouter } from  'vue-router'



export function ajaxGet(url, params, isShow, callbackSuc, callbackErr){
    ajax('get', url, params, isShow, callbackSuc, callbackErr)
    // axios.get(url, {params: params})
    // .then(function (response) {
    //     ajaxCall(response, isShow, callbackSuc, callbackErr)
    // })
    // .catch(function (error) {
    //     console.info(error)
    //     dialogShowAuto('网络连接失败!')
    // })
}

export function ajaxPost(url, data, isShow, callbackSuc, callbackErr){
    ajax('post', url, data, isShow, callbackSuc, callbackErr)
    // axios({ method: 'post', url: url, data: data})
    // .then(function (response) {
    //     ajaxCall(response, isShow, callbackSuc, callbackErr)
    // })
    // .catch(function (error) {
    //     console.info(error)
    //     dialogShowAuto('网络连接失败!')
    // })

    // axios.post(url, params)
    // .then(function (response) {
    //     ajaxCall(response, isShow, callbackSuc, callbackErr)
    // })
    // .catch(function (error) {
    //     console.info(error)
    //     dialogShowAuto('网络连接失败!')
    // })
}

export default function ajax(method, url, data, isShow, callbackSuc, callbackErr){

    const store = useStore()
    const router = useRouter()
    const config = {
        method: method, 
        url: url, 
        data: (method === 'post') ? data : null,
        params: (method === 'get') ? { data } : {},
    }
    axios(config)
    .then(function (response) {
        const resultData = response.data;
        console.info(resultData)
        if(resultData.status == 'success'){
            if(callbackSuc != null &&  typeof callbackSuc === 'function'){
                callbackSuc(resultData)
            }
        }else{
            console.info('**************************')
            if(resultData.code == '2000001'){
                dialogShowAuto(resultData.msg)
                store.commit('removeUserInfo')
                router.push('/login')
            }else if(callbackErr != null &&  typeof callbackErr === 'function'){
                callbackErr(resultData)
            }
        }
        if(isShow){
            dialogShowAuto(resultData.msg)
        }
    })
    .catch(function (error) {
        console.info(error)
        dialogShowAuto('网络连接失败!')
    })

}