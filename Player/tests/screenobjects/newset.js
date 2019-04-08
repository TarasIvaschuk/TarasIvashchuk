// async function delay(ms){
//     await (
//         new Promise (function(res){
//             setTimeout (function(){
//                 res(console.log ("inside settimeout"));
//             }, ms)
//         })
//     );
// }

// delay(4000).then(function(){
//     console.log("hello world")
// })



new Promise((resolve) => {
  
    setTimeout(() => resolve(console.log ("done")), 2000);
  
  });