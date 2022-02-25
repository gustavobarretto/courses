let objFlow = 'flow'

function createObject({string, stage, currentFlow = ''}) {
  if(currentFlow) {
    objFlow = currentFlow;
    return {
      string,
      stage,
      currentFlow 
    }
  }
  return {
    string,
    stage
  }
}

console.log(createObject({
  string: 'Oi, Runas',
  stage: 'poisition_stage',
  currentFlow: 'changeFlow'
}))

console.log({objFlow})