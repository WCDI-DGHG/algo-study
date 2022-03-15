function solution(n, lost, reserve) {
    lost.sort();
    reserve.sort();
    
    for(let i = 0; i < reserve.length; i ++){
        for(let j = 0; j < lost.length; j ++){
            if(lost[j] == reserve[i]) {
                lost.splice(j,1);
                reserve.splice(i,1);
                i=0;j=0;
            }
        }
    }
    let count = n - lost.length;
    lost.forEach((val,j) => {
        reserve.find((v,i) => {
            if(v === val){
                reserve.splice(i,1);
                count++;
                return;
            }            
           if(v - 1 === val) {
                reserve.splice(i,1);
                count++;
               return;
           } 
           if(v + 1 === val) {
                reserve.splice(i,1);
                count++;
            }
        });
    });
    
    return count;
}