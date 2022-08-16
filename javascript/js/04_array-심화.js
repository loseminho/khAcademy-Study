const arr1 = ["hi","hello",100,true,[1,2,3]];
for(let i=0;i<arr1.length;i++){
    console.log(i,arr1[i]);
}

// item : 반보갛면서 접근하는 배열의 각 요소 -> arr1[i]
// index : 인덱스번호 -> i
// 매개변수 순서 중요하며, 순서만 맞추면 변수 이름 상관없음
// indext 번호가 필요 없는 경우 index는 매개변수에서 생략 가능
arr1.forEach(function(item,index){
    console.log(index, item);
});

// map : forEach와 마찬가지로 배열을 순회, 리턴하는 값을 다시 배열로 생성
// 배열의 데이터를 가공해서 새로운 배열을 만들떄 사용

const arr2 = arr1.map(function(item,index){
    const str = `${index}번째 item : ${item}`;
    console.log(str);
    return str;
});
console.log(arr2);//배열로 묶여서 저장이 됨


// filter : 배열에서 특정 조건에 만족하는 데이터만 필터링 할 때 사용
const arr3 = [6,2,3,5,4,1];
const arr4 = arr3.filter(function(item,index){
    console.log(index, item);
    return item>3;
    // 해당 값에 true인 값만 배열에 담음.
});
console.log(arr4);

// reduce : 배열의 값을 이용해서 연산하여 특정 값을 도출할 때 사용
const sum = arr3.reduce(function(acc,curr,index){
    //첫번째 반복회차 생략이 됨. 따라서 반복은 5회만 진행이 되지만 모든 값이 더해짐
    //index=1일때가 최초 ->acc(0번 인덱스 값), curr(1번 인덱스 값)
    // curr에는 해당 인덱스 번호의 요소가 대입
    console.log(acc, curr, index);
    //한바퀴 돈 후 acc에는 acc+curr한 값이 들어감
    return acc+curr;
});
console.log(sum);














