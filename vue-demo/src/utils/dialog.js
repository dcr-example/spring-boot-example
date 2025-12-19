
import store from "@/store"

export function dialogShow(msg){
    store.commit('showGlobalDialog', msg)
}
export function dialogShowAuto(msg){
    store.commit('showGlobalDialogAuto', msg)
}

export default {}
