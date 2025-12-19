
import { createStore } from 'vuex'

const store = createStore({
    state() {
        const userSession = JSON.parse(localStorage.getItem('userSession'))
        return {
          isAuthenticated: userSession != null ? true : false,
          userInfo: userSession,

          globalDialog: {
            isShow: false,
            message:''
          },

        }
    }, 
    mutations: {
        setUserInfo(state, userInfo){
            if(userInfo != null){
                state.isAuthenticated = true
                state.userInfo = userInfo
                localStorage.setItem('userSession', JSON.stringify(userInfo));
            }else{
                store.commit('removeUserInfo')
            }
        },
        removeUserInfo(state){
          state.isAuthenticated = false
          state.userInfo = null
          localStorage.removeItem('userSession');
        },
        showGlobalDialogAuto(state, msg){
            store.commit('showGlobalDialog', msg)
            setTimeout(() => {
                store.commit('hideGlobalDialog')
            }, 2000);
            
        },
        showGlobalDialog(state, msg){
            state.globalDialog.message = msg
            state.globalDialog.isShow = true
        },
        hideGlobalDialog(state){
            state.globalDialog.isShow = false
            state.globalDialog.message = ''
        }
    },
    getters: {
        getUserInfo(state){
            return state.userInfo
        }
    }
})

export default store