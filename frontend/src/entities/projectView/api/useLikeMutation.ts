// import {useMutation, useQueryClient} from '@tanstack/react-query';
// import {postLike} from "./like.ts";
//
// export const useLikeMutation = () => {
//   const queryClient = useQueryClient();
//   const likeMutation = useMutation({
//       mutationFn: (projectId:number)=> postLike(projectId),
//       onSuccess: () = {
//           queryClient.invalidateQueries({ queryKey:['project']})
//       },
//   });
// };
