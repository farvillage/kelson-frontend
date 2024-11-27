import React from 'react'
import { Box, Typography, Grid, Paper } from '@mui/material'

const Inicial = () => {
  return (
    <Box sx={{ p: 4, backgroundColor: '#f0f0f0', borderRadius: '8px' }}>
        <Paper elevation={3} sx={{ p: 3, mb: 4, backgroundColor: '#ffffff', borderRadius: '8px' }}>
            <Typography variant='body1' paragraph>
            A Faculdade UNIESP é uma instituição comprometida em fornecer educação de qualidade, com foco no desenvolvimento profissional e pessoal dos alunos. Nossos cursos são projetados para atender às demandas do mercado de trabalho e preparar nossos alunos para os desafios da vida profissional.
            </Typography>
            <Typography variant='body1' paragraph>
          Contamos com uma equipe de professores qualificados, uma infraestrutura moderna e uma metodologia de ensino que valoriza o aprendizado prático. Oferecemos diversos cursos nas áreas de tecnologia, negócios, saúde, entre outros, sempre com o objetivo de formar profissionais capacitados e comprometidos.
        </Typography>
        <Typography variant='body1' paragraph>
          A seguir, conheça mais sobre as áreas e as oportunidades que a Faculdade UNIESP oferece para você.
        </Typography>
        </Paper>
        <Grid container spacing={4}>
        <Grid item xs={12} md={4}>
          <Paper elevation={3} sx={{ p: 3, backgroundColor: '#ffffff', borderRadius: '8px', textAlign: 'center' }}>
            <img
              src="https://images.unsplash.com/photo-1556761175-4b46a572b786?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxMTc3M3wwfDF8c2VhcmNofDJ8fGNvbGxlZ2V8ZW58MHx8fHwxNjI2NzUwNzY0&ixlib=rb-1.2.1&q=80&w=400"
              alt="Campus Life"
              style={{ width: '100%', borderRadius: '8px' }}
            />
            <Typography variant='h6' gutterBottom mt={2}>
              Vida no Campus
            </Typography>
            <Typography variant='body2'>
              Um ambiente vibrante e acolhedor, com atividades que promovem o desenvolvimento pessoal e social dos alunos.
            </Typography>
          </Paper>
        </Grid>

        <Grid item xs={12} md={4}>
          <Paper elevation={3} sx={{ p: 3, backgroundColor: '#ffffff', borderRadius: '8px', textAlign: 'center' }}>
            <img
              src="https://images.unsplash.com/photo-1571260899304-425eee4c7efc?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxMTc3M3wwfDF8c2VhcmNofDJ8fGxpYnJhcnl8ZW58MHx8fHwxNjI2NzUwODE2&ixlib=rb-1.2.1&q=80&w=400"
              alt="Library"
              style={{ width: '100%', borderRadius: '8px' }}
            />
            <Typography variant='h6' gutterBottom mt={2}>
              Biblioteca
            </Typography>
            <Typography variant='body2'>
              Uma biblioteca com um acervo completo e atualizado, incluindo livros, revistas e recursos digitais para pesquisa e estudo.
            </Typography>
          </Paper>
        </Grid>

        <Grid item xs={12} md={4}>
          <Paper elevation={3} sx={{ p: 3, backgroundColor: '#ffffff', borderRadius: '8px', textAlign: 'center' }}>
            <img
              src="https://images.unsplash.com/photo-1652974731232-efc86a9bd985?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
              alt="Main Building"
              style={{ width: '100%', borderRadius: '8px' }}
            />
            <Typography variant='h6' gutterBottom mt={2}>
              Prédio Principal
            </Typography>
            <Typography variant='body2'>
              O centro de nossa instituição, com salas de aula modernas e laboratórios equipados para atender às necessidades dos cursos.
            </Typography>
          </Paper>
        </Grid>
      </Grid>

      <Grid container spacing={4} sx={{ mt: 4 }}>
        <Grid item xs={12} md={6}>
          <Paper elevation={3} sx={{ p: 3, backgroundColor: '#ffffff', borderRadius: '8px', textAlign: 'center' }}>
            <Typography variant='h6' gutterBottom mt={2}>
              Parcerias com Empresas
            </Typography>
            <Typography variant='body2'>
              A UNIESP mantém parcerias com diversas empresas, permitindo que nossos alunos tenham acesso a oportunidades de estágio e emprego logo após a graduação. Essas parcerias são fundamentais para integrar os estudantes ao mercado e para oferecer uma experiência educacional alinhada com a prática profissional.
            </Typography>
          </Paper>
        </Grid>

        <Grid item xs={12} md={6}>
          <Paper elevation={3} sx={{ p: 3, backgroundColor: '#ffffff', borderRadius: '8px', textAlign: 'center' }}>
            <Typography variant='h6' gutterBottom mt={2}>
              Compromisso com a Educação
            </Typography>
            <Typography variant='body2'>
              A UNIESP se dedica a oferecer uma educação acessível e de qualidade, acreditando que o conhecimento transforma vidas. Nossos programas são desenhados para preparar os alunos não apenas para carreiras, mas para que eles possam fazer contribuições significativas para a sociedade.
            </Typography>
          </Paper>
        </Grid>
      </Grid>
    </Box>
  )
}

export default Inicial
