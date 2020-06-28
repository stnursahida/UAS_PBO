
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author m4rh3
 */
import java.sql.*;
import java.util.*;

/**
 *
 * @author windows
 */
public abstract class ProfileImpl implements ProfileServices {

    @Override
    public Profil insert(Profil BIO) throws SQLException {
        PreparedStatement st = KoneksiDb.getConnection().prepareStatement("insert into biodata values(?,?,?,?,?)");
        st.setString(1, BIO.getId());
        st.setString(2, BIO.getNama());
        st.setString(3, BIO.getAlamat());
        st.setString(4, BIO.getJk());
        st.setString(5, BIO.getEmail());
        st.executeUpdate();



        return BIO;
    }

    @Override
    public void update(Profil BIO) throws SQLException {
        PreparedStatement st = KoneksiDb.getConnection().prepareStatement("update biodata set nama=?,alamat=?,jk=?,email=? where nomhs=?");

        st.setString(1, BIO.getNama());
        st.setString(3, BIO.getAlamat());
        st.setString(4, BIO.getJk());
        st.setString(5, BIO.getEmail());
        st.setString(3, BIO.getId());
        st.executeUpdate();

    }
    
    public void delete(int id) throws SQLException {
        PreparedStatement st = KoneksiDb.getConnection().prepareStatement("delete from biodata where id=?");
        st.setInt(1, id);
        st.executeUpdate();
    }

    @Override
    public List getAll() throws SQLException {
        Statement st = KoneksiDb.getConnection().createStatement();
        ResultSet rs = st.executeQuery("select * from biodata");
        List list = new ArrayList();
        while (rs.next()) {
            Profil p = new Profil();
            p.setId(rs.getString("id"));
            p.setNama(rs.getString("nama"));
            p.setAlamat(rs.getString("alamat"));
            p.setJk(rs.getString("jk"));
            p.setEmail(rs.getString("email"));
            list.add(p);
        }
        return list;
    }
}
