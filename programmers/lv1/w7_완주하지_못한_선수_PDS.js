const solution = (participant, completion) => {
    participant.sort();
    completion.sort();
    return participant.filter((val,index) => {
        if(completion[index] !== participant[index]){
            return true;
        }
        return false;
    })[0];
}