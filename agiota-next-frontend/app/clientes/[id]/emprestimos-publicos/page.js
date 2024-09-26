import Link from "next/link";
import { listarEmprestimosPublicos } from "@/app/lib/funcoes.js";
import { carregarIdDeUsuarioPorEmail } from "@/app/lib/funcoes";
import { getServerSession } from "next-auth/next";
import { authOptions } from "@/app/api/auth/[...nextauth]/route";

export default async function EmprestimosPublicos({params}) {
  const session = await getServerSession(authOptions);
    const userId = await carregarIdDeUsuarioPorEmail(session?.user?.email);
    const emprestimos = await listarEmprestimosPublicos(params.id);

    if (!session || !userId) {
    redirect("/login");
  }
    if(emprestimos != null) {
      return (
        <main className="flex flex-col items-center">
         <h1>Lista de Empréstimos publicados por Agiotas</h1>
          {
            emprestimos.map(emprestimo => {
              return <div key={emprestimo.id}>
                  {emprestimo.id} - Estado: {emprestimo.estado} - Empréstimo de R${emprestimo.valorEmprestado} com retorno mínimo de R${emprestimo.valorASerPago}
                  <Link href={`/clientes/${params.id}/emprestimos-publicos/${emprestimo.id}`}>| Detalhar Empréstimo </Link>
                </div>
             })
          }
        </main>
      );
    } else {
      return (
        <main className="flex flex-col items-center">
            <h1>Empréstimos não encontrados.</h1>
        </main>
      )
    }
}
