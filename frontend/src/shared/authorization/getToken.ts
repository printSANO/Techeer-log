// zustand
// import useStore from './useStore'
// import { useTokenStore } from './stores/useTokenStore'
// const token = useStore(useTokenStore, (state) => state.bears)
const token = sessionStorage.getItem('accessToken');
export const accessToken = token? token.split(' ')[1]: '';
