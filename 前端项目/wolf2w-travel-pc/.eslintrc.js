module.exports = {
  env: {
    browser: true,
    es2021: true
  },
  extends: ['plugin:prettier/recommended', 'plugin:vue/vue3-recommended', 'plugin:@typescript-eslint/recommended', 'plugin:nuxt/recommended'],
  parserOptions: {
    ecmaVersion: 'latest',
    parser: '@typescript-eslint/parser',
    sourceType: 'module'
  },
  plugins: ['@typescript-eslint'],
  rules: {
    'vue/multi-word-component-names': 0, //关闭vue文件和组件命名校验
    'vue/singleline-html-element-content-newline': 'off', // 单行html元素内容在新的一行
    'vue/multiline-html-element-content-newline': 'off', // 多行html元素内容在新的一行
    'vue/html-closing-bracket-newline': 'off', // html右括号在新的一行
    'vue/max-attributes-per-line': 0,
    '@typescript-eslint/no-explicit-any': ['off'],
    'vue/html-self-closing': 0,
    'no-console': process.env.NODE_ENV === 'production' ? 'error' : 'warn',
    'no-debugger': process.env.NODE_ENV === 'production' ? 'error' : 'warn',
    'prettier/prettier': [
      'error',
      {
        printWidth: 300, //代码单行长度
        tabWidth: 2, //tab键缩进为2空格
        useTabs: false, //使用空格缩进
        singleQuote: true, //js单引号
        semi: false, //去分号
        trailingComma: 'none', //无尾逗号
        arrowParens: 'avoid' //箭头函数尽可能省略括号
        // jsxBracketSameLine: false //标签换行后>单独一行
      }
    ]
  }
}
