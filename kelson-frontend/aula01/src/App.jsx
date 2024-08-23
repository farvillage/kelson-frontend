
import Plus from './components/Plus'
import Minus from './components/Minus'
import Times from './components/Times'
import Division from './components/Division'
import NeedTo from './components/NeedTo'

const App = () => {
  return (
    <div>
      <Plus num1={2} num2={2} />
      <Minus num1={2} num2={2}/>
      <Times num1={2} num2={2}/>
      <Division num1={2} num2={2}/>
      <NeedTo nameOfTech = "Node.JS"/>
    </div>
  )
}

export default App